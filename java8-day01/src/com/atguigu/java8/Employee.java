package com.atguigu.java8;

public class Employee {

	private Integer age;
	
	private String name;
	
	private double salary;
	
	private Status status;

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Employee(Integer age, String name, double salary) {
		super();
		this.age = age;
		this.name = name;
		this.salary = salary;
	}

	public Employee(Integer age, String name, double salary, Status status) {
		this.age = age;
		this.name = name;
		this.salary = salary;
		this.status = status;
	}

	public Employee() {
		super();
	}
	
	public Employee(Integer age) {
		super();
		this.age = age;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(salary);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(salary) != Double.doubleToLongBits(other.salary))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [age=" + age + ", name=" + name + ", salary=" + salary + ", status=" + status + "]";
	}

	public enum Status{
		FREE,
		BUSY,
		VOCATION;
	}
}
