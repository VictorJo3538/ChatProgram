package chat.user;

public class User {
	
	int id;
	String name;
	
	public User(int id_, String name_) {
		id = id_;
		name = name_;
	}
	
	public String getName() {
		return name;
	}
}
