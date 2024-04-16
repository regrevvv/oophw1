package hw1.no3.ch5_6;

public class Employee {
	protected int baseSalary;
	protected int allowance;
	protected int bonus;
	
	//월급 반환 함수
	public int salary() {
		return this.baseSalary + this.allowance + this.bonus;
	}
}

class WageEmployee extends Employee {
	protected int workDay;
	protected int dailyWage;
	
	@Override
	public int salary() {
		return (this.workDay * this.dailyWage + this.allowance + this.bonus);
	}
}

class SalesPerson extends WageEmployee {
	private int piecework;
	
	@Override
	public int salary() {
		return super.salary() + this.piecework;
	}
}

class Manager extends Employee {
	public int salary() {
		return super.salary();
	}
}