package com.association;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Department {
		@Id
		private int deptId;
		
		private String deptName;
		
		@OneToMany(mappedBy = "department")
		private List<Employee> list=new ArrayList<Employee>();
		
		
		
		
		
		

		public Department(int deptId, String deptName, List<Employee> list) {
			super();
			this.deptId = deptId;
			this.deptName = deptName;
			this.list = list;
		}

		public Department() {
			super();
			
		}

		@Override
		public String toString() {
			return "Department [deptId=" + deptId + ", deptName=" + deptName + ", list=" + list + "]";
		}

		public int getDeptId() {
			return deptId;
		}

		public void setDeptId(int deptId) {
			this.deptId = deptId;
		}

		public String getDeptName() {
			return deptName;
		}

		public void setDeptName(String deptName) {
			this.deptName = deptName;
		}

		public List<Employee> getList() {
			return list;
		}

		public void setList(List<Employee> list) {
			this.list = list;
		}
		
		
		
		
		
		
		
		
}
