<script setup lang="ts">
import QuizCard from "./QuizCard.vue";
</script>

<template>
  <div>
    <h3>Search Quizzes</h3>
    <input type="text" placeholder="Search for tags here" id="search" />
    <QuizCard
      :data="{
        id: 'test',
        name: 'Name',
        createdBy: 'Nevah5',
        tags: ['a', 'b', 'c'],
      }"
    />
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
