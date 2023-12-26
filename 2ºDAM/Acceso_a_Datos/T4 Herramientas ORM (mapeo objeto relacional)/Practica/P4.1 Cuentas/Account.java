package ormlite;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "accounts")
public class Account {
	//se crean las variables constantes necesarias para encontrar los campos
	public static final String NAME_FIELD_NAME = "name";
	public static final String PASSWORD_FIELD_NAME = "passwd";
	//se introducen en las anotaciones
	@DatabaseField(generatedId = true)
	private int id;
	@DatabaseField(columnName = NAME_FIELD_NAME, canBeNull = false)
	private String name;
	@DatabaseField(columnName = PASSWORD_FIELD_NAME)
	private String password;
	//todas las clases persistentes deben definir un constructor vacío sin atributo de visiblidad
	Account() {}
	//se crean diferentes constructores con diferentes parámetros
	public Account(String name) {
		this.name = name;
	}
	public Account(String name, String password) {
		this.name = name;
		this.password = password;
	}
	//se crean los getters y setters correspondientes a las variables creadas
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	//se sobrescribe el método hashCode con el objetivo de retornar la variables nombre con este método
	@Override
	public int hashCode() {
		return name.hashCode();
	}
	//se sobreescribe el método equals el cual compara el nombre con otro objeto Account (para ver si son o no iguales)
	@Override
	public boolean equals(Object other) {
		if (other == null || other.getClass() != getClass()) {
			return false;
		}
		return name.equals(((Account) other).name);
	}
}
