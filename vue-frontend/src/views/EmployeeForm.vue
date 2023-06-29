<template>
  <div class="container">
    <h2>Registration Form</h2>
    <hr />
    <form @submit.prevent="onCreatePost">
      <div class="form-group">
        <!-- <label>First Name</label> -->
        <input
          type="text"
          class="form-control"
          v-model="firstName"
          placeholder="First Name"
          required
        />
      </div> <br>

      <div class="form-group">
        <!-- <label for="lastName">Last Name</label> -->
        <input
          type="text"
          class="form-control"
          v-model="lastName"
          placeholder="Last Name"
          required
        />
      </div><br>

      <div class="form-group">
        <!-- <label for="Email">Email</label> -->
        <input
          type="email"
          class="form-control"
          v-model="email"
          placeholder="Email"
          required
        />
      </div> <br>

      <button type="submit" class="mt-3 btn btn-success">Register</button>
    </form>
  </div>
</template>
<script>
import EmployeeService from "../services/EmployeeService";
export default {
  data() {
    return {
      firstName: "",
      lastName: "",
      email: "",
    };
  },
  methods: {
    onCreatePost() {
      EmployeeService.createEmployee({
        firstName: this.firstName,
        lastName: this.lastName,
        email: this.email,
      }).then((response) => {
        alert("Successfully Registered");
        console.log(response);
        this.$router.push("/employee");
      });
    },
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