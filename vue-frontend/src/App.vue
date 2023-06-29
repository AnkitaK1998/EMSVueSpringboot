<template>
  <div id="nav">
    <router-link to="/">Home</router-link> |
    <router-link to="/employee">Employee List</router-link> |
    <router-link to="/employeeForm"> Employee Registration Form</router-link>
  </div>
  <router-view />
</template>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
#nav {
  padding: 20px;
  background-color: rgb(15, 15, 15);
  margin-bottom: 80px;
}
#nav a {
  font-weight: bold;
  color: #448a5d;
}
#nav a.router-link-exact-active {
  color: #cfc9e6;
}
</style>