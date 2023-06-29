<template>
  <div class="container">
    <h2>Employee List</h2>
    <hr />
    <table class="table table-dark">
      <thead class="thead-dark">
        <th>
        <input type="checkbox" v-model="allSelected" @change="selectAll" />
        </th>
        <th>Employee Id</th>
        <th>Employee First Name</th>
        <th>Employee Last Name</th>
        <th>Employee Email</th>
        <th>Action</th>
      </thead>
      <tbody>
        <tr v-for="employee in employees" :key="employee.id">
          <td>
            <input type="checkbox" v-model="selected" :value="employee.id" />
          </td>

          <!-- <router-link :to="'/employee/${employee.id}'">{{employee.id}} </router-link></td> -->
          <td>
            <router-link
              :to="{ name: 'updateform', params: { id: employee.id } }"
              >{{ employee.id }}</router-link
            >
          </td>
          <td>{{ employee.firstName }}</td>
          <td>{{ employee.lastName }}</td>
          <td>{{ employee.email }}</td>
          <td>
            <router-link
              :to="{ name: 'deleteform', params: { id: employee.id } }"
              ><button class="btn btn-danger">Delete</button></router-link
            >
          </td>
        </tr>
      </tbody>
    </table>
    <br />

    <!-- <span>Selected Ids: {{ selected }} </span> -->
  </div>
</template>
  <script>
import EmployeeService from "../services/EmployeeService";

export default {
  name: "Employee",
  data() {
    return {
      employees: [],
      selected: [],
      allSelected: false,
    };
  },
  methods: {
    getEmployes() {
      EmployeeService.getEmployees().then((response) => {
        this.employees = response.data;
      });
    },
    selectAll() {
      this.employeeIds = [];
      if (this.allSelected) {
        const selected = this.employees.map((employee) => employee.id);
        this.selected = selected;
      } else {
        this.selected = [];
      }
    },
  },
  created() {
    this.getEmployes();
  },
};
</script>
<style scoped>
h2{
  font-weight: bold;
  color: black;
}

</style>
  