package com.pravin.java.examples.record;

public record Employee(Long id, String name, String company, Integer age) {

    public static class EmployeeBuilder {

        private Long id;
        private String name;
        private String company;
        private Integer
                age;

        public EmployeeBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public EmployeeBuilder name(String name) {
            this.name = name;
            return this;
        }

        public EmployeeBuilder company(String company) {
            this.company = company;
            return this;
        }

        public EmployeeBuilder age(Integer age) {
            this.age = age;
            return this;
        }

        public Employee build() {
            return new Employee(id, name, company, age);
        }
    }
}
