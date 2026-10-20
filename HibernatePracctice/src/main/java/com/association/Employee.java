package com.association;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Employee {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int empId;
		private String name;
		
		@ManyToOne
		@JoinColumn(name = "deptId")
		private Department department;


		public Employee() {
		
		}

		public Employee(int empId, String name, Department department) {
			super();
			this.empId = empId;
			this.name = name;
			this.department = department;
		}

		@Override
		public String toString() {
			return "Employee [empId=" + empId + ", name=" + name + ", department=" + department + "]";
		}

		public int getEmpId() {
			return empId;
		}

		public void setEmpId(int empId) {
			this.empId = empId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Department getDepartment() {
			return department;
		}

		public void setDepartment(Department department) {
			this.department = department;
		}
		
		
		
		
		
}
