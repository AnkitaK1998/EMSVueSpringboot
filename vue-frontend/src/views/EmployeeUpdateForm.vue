<template>
  <div class="container">
    <h2>Update form</h2> <hr>
    <form @submit.prevent="onEmployeeUpdate">
      <div class="form-row">
        <div class="form-group">
          <!-- <label for="firstName" class="control-label" col-lg-6
            >first Name</label -->
          <!-- > -->
          <input
            type="text"
            class="form-control"
            v-model="employeeData.firstName"
            required
          />
        </div> <br>
        <div class="form-group">
          <!-- <label>last Name</label> -->
          <input
            type="text"
            class="form-control"
            v-model="employeeData.lastName"
            required
          />
        </div> <br>
        <div class="form-group">
          <!-- <label>E-mail</label> -->
          <input
            type="email"
            class="form-control"
            v-model="employeeData.email"
            required
          />
        </div> <br>

        <button type="submit" class="mt-3 btn btn-success">Update</button>
      </div>
    </form>
  </div>
</template>
    
    <script>
import EmployeeService from "../services/EmployeeService";
export default {
  data() {
    return {
      id: "",
      employeeData: {},
    };
  },
  methods: {
    onEmployeeUpdate() {
      console.log("inside update");
      EmployeeService.updateEmployee(this.employeeData).then((response) => {
        console.log(" then", response);
        alert("Successfully updated employee details");
        this.$router.push("/employee");
      });
    },
  },
  created() {
    console.log(this.$route.param);
    this.id = this.$route.params.id;
    EmployeeService.getEmployeeData(this.id).then((response) => {
      // console.log(response.data)
      this.employeeData = response.data;
    });
    console.log(this.id);
  },
};
</script>
    <style scoped>
.container{
  height: 500px;
  width: 500px;
}
button{
  background-color: rgb(158, 158, 203);
  border-radius: 5px;
}

h2{
  font-weight: bold;
  color: black;
}

</style>