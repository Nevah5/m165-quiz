<script setup lang="ts">
import QuizCard from "./QuizCard.vue";
import { onMounted, ref } from "vue";

interface Quiz {
  id: string;
  name: string;
  createdBy: string;
  createdOn: number;
  tags: string[];
}

var data = ref<null | Quiz[]>();
var searchString: string;
var timeout: number;

onMounted(() => {
  fetch("http://localhost:8080/quizzes")
    .then((d) => d.json())
    .then((json) => (data.value = json));
});

const search = () => {
  if (searchString == null || searchString == "") {
    fetch("http://localhost:8080/quizzes")
      .then((d) => d.json())
      .then((json) => (data.value = json));
    return;
  }
  clearTimeout(timeout);
  timeout = setTimeout(() => {
    fetch(`http://localhost:8080/quizzes?search=${searchString}`)
      .then((d) => d.json())
      .then((json) => (data.value = json));
  }, 600);
};
</script>

<template>
  <div>
    <h3>Search Quizzes</h3>
    <input
      type="text"
      placeholder="Search for tags here"
      id="search"
      v-model.trim="searchString"
      :onkeypress="() => search()"
    />
    <QuizCard v-for="quiz in data" :key="quiz.id" :data="quiz" />
  </div>
</template>

<style scoped>
input#search {
  width: 600px;
  border: solid black 3px;
  border-radius: 0.5em;
  height: 40px;
  margin: 0 0 30px;
  padding: 0 0 0 10px;
}
</style>

<style>
div.card {
  margin: 0 0 10px;
}
</style>
