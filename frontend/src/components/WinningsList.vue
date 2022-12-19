<script setup lang="ts">
const values = [
  "1'000'000",
  "500'000",
  "125'000",
  "64'000",
  "32'000",
  "16'000",
  "8'000",
  "4'000",
  "2'000",
  "1'000",
  "500",
  "300",
  "200",
  "100",
  "50",
];
const currencySymbol = "CHF";
const props = defineProps(["current"]);
</script>

<template>
  <ul>
    <li
      v-for="(value, index) in values"
      :key="value"
      :id="props.current == 15 - index ? 'current' : ''"
    >
      <span>{{ 15 - index }}</span
      ><span>{{ currencySymbol }} {{ value }}</span>
    </li>
  </ul>
</template>

<style scoped>
ul {
  margin: 0;
  padding: 10px;
  width: 300px;
  list-style-type: none;
  border: solid #4458b1 4px;
  border-radius: 0.5em;
  background-color: #010a34;
}

li {
  margin: 3px 0;
  font-family: "Unbounded", cursive;
  clip-path: polygon(0 50%, 10% 100%, 90% 100%, 100% 50%, 90% 0, 10% 0);
  padding: 5px 10px;
  display: grid;
  column-gap: 10%;
  grid-template-columns: 20% 70%;
  color: #e37d1c;
}
li#current {
  background: radial-gradient(#f58a0a, #d5761f, #faf7b5);
  color: black;
}

li span:first-child {
  margin: 0 10%;
  position: relative;
  text-align: right;
}
li span:first-child::after {
  content: "";
  display: inline-block;
  position: absolute;
  transform: translateY(-50%);
  top: 50%;
  border-radius: 50%;
  height: 7px;
  width: 7px;
  background-color: white;
  margin-left: 10px;
}
</style>
