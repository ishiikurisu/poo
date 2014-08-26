#include <iostream>
#include <string>

class Client {
	string name;
	int cpf;
	
	Client(string his_name, int his_cpf) {
		name = his_name;
		cpf = his_cpf;
	}
	
	int get_cpf() {
		return cpf;
	}
	
	int set_cpf(int new_cpf) {
		cpf = new_cpf;
		return cpf;
	}
	
	string get_name() {
		return name;
	}
	string set_name(string new_name) {
		name = new_name;
		return name;
	}
};

class Account {
	Client owner;
	int id;
	float money;
	
	Account(Client new_owner, int new_id, float new_money) {
		owner = new_owner;
		id = new_id;
		money = new_money;
	}
	
	public float get_money() {
		return money;
	}
	
	void spend(float quantity) {
		money += quantity;
	}
};

int main() {
	Client joe = new Client("joe", 666);
	Account account = new Account(joe, 0, 25);
	
	cout << joe.get_name() << " has " << account.get_money() << "$\n";
	return 0;
}
