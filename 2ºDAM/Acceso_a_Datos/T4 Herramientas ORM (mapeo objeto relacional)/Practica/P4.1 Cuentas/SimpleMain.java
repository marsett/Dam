package ormlite;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.misc.TransactionManager;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.SelectArg;
import com.j256.ormlite.support.ConnectionSource;

public class SimpleMain {
	//se crea la variable constante, donde se inserta el nombre de la base de datos creada en MySQL Workbench
	private final static String DATABASE_URL = "dbprueba";
	//se crea una variable de tipo Dao, cuyo tipado es de la clase Account y de tipo Integer
	private Dao<Account, Integer> accountDao;

	public static void main(String[] args) throws Exception {
		//se crea la conexión con el driver de MySQL
		Class.forName("com.mysql.cj.jdbc.Driver");
		new SimpleMain().doMain(args);
	}

	private void doMain(String[] args) throws Exception {
		ConnectionSource connectionSource = null;
		try {
			//se crea la conexion con la ruta, el nombre de usuario y la contraseña puesta en el Workbench
			connectionSource = new JdbcConnectionSource("jdbc:mysql://localhost:3306/"+DATABASE_URL,"root","mysql");
			//se configura la base de datos llamando a la conexion que se acaba de inicializar
			setupDatabase(connectionSource);
			//se escribe y leen los datos
			readWriteData();
			//se realizan varias operaciones
			readWriteBunch();
			//muestra cómo usar el objeto SelectArg
			useSelectArgFeature();
			useTransactions(connectionSource);
			System.out.println("\n\nIt seems to have worked\n\n");
		} finally {
			//se cierra la conexión si no se encuentra nada con qué conectar
			if (connectionSource != null) {
				connectionSource.close();
			}
		}
	}

	/**
	 * se configura la base de datos y DAOs
	 */
	private void setupDatabase(ConnectionSource connectionSource) throws Exception {

		accountDao = DaoManager.createDao(connectionSource, Account.class);
		//TableUtils.createTable(connectionSource, Account.class);
	}

	/**
	 * se lee y escribe algunos datos como ejemplo
	 */
	private void readWriteData() throws Exception {
		//se crea una instancia de Account
		String name = "Jim Coakley";
		Account account = new Account(name);

		//persiste el objeto Account en la base de datos
		accountDao.create(account);
		int id = account.getId();

		//se crea una contraseña
		account.setPassword("_secret");
		//se actualiza la base de datos después de cambiar el objeto
		accountDao.update(account);

		//consulta sobre todo los items que hay en la base de datos
		List<Account> accounts = accountDao.queryForAll();

		//se crea un bucle de objetos en la base de datos
		int accountC = 0;
		for (Account account2 : accountDao) {
			accountC++;
		}

		//se construye una consulta usando QueryBuilder
		QueryBuilder<Account, Integer> statementBuilder = accountDao.queryBuilder();
		statementBuilder.where().like(Account.NAME_FIELD_NAME, "hello");
		accounts = accountDao.query(statementBuilder.prepare());

		//debe encontrar la cuenta
		statementBuilder.where().like(Account.NAME_FIELD_NAME, name.substring(0, 3) + "%");
		accounts = accountDao.query(statementBuilder.prepare());

		//se borra la cuenta
		accountDao.delete(account);
	}

	/**
	 * ejemplo de lectura y escritura de una lista de objetos numéricos
	 */
	private void readWriteBunch() throws Exception {

		Map<String, Account> accounts = new HashMap<String, Account>();
		for (int i = 1; i <= 100; i++) {
			String name = Integer.toString(i);
			Account account = new Account(name);
			//persiste el objeto Account a la base de datos
			accountDao.create(account);
			accounts.put(name, account);
		}

		//consulta de todos los items en la base de datos
		List<Account> all = accountDao.queryForAll();
		for (Account account : all) {
		}

		//se crea un bucle de esos items en la base de datos
		int accountC = 0;
		for (Account account : accountDao) {
			accountC++;
		}
	}

	/**
	 * ejemplo sobre una consulta creada con un argumento usando el objeto SelectArg. Entonces puede fijarse el valor de este objeto un tiempo después
	 */
	private void useSelectArgFeature() throws Exception {

		String name1 = "foo";
		String name2 = "bar";
		String name3 = "baz";

		QueryBuilder<Account, Integer> statementBuilder = accountDao.queryBuilder();
		SelectArg selectArg = new SelectArg();
		//se construye un consulta donde la cláusula WHERE fija el nombre
		statementBuilder.where().like(Account.NAME_FIELD_NAME, selectArg);
		PreparedQuery<Account> preparedQuery = statementBuilder.prepare();

		//se puede fijar el argumento a seleccionar y ejecutar la consulta
		selectArg.setValue(name1);
		List<Account> results = accountDao.query(preparedQuery);

		selectArg.setValue(name2);
		results = accountDao.query(preparedQuery);

		selectArg.setValue(name3);
		results = accountDao.query(preparedQuery);
	}

	/*
	 * ejemplo sobre una consulta creada con un argumento usando el objeto SelectArg. Entonces puede fijarse el valor de este objeto un tiempo después
	 */
	private void useTransactions(ConnectionSource connectionSource) throws Exception {
		String name = "trans1";
		final Account account = new Account(name);

		TransactionManager transactionManager = new TransactionManager(connectionSource);
		try {
			//se intenta algo en la transacción
			transactionManager.callInTransaction(new Callable<Void>() {
				@Override
				public Void call() throws Exception {
					//se borra: entonces, se lanza una excepción la cual llama al rollback
					throw new Exception("We throw to roll back!!");
				}
			});
		} catch (SQLException e) {
			//esperado
		}
	}
}
