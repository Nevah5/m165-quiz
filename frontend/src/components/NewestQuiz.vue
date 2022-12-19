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

var data = ref<null | Quiz>();

onMounted(() => {
  fetch("http://localhost:8080/quiz/top")
    .then((d) => d.json())
    .then((json) => (data.value = json));
});
</script>

<template>
  <div v-if="data" id="top">
    <h3>Newest Quiz:</h3>
    <QuizCard :data="data" />
  </div>
  <p v-else>Loading...</p>
</template>

<style scoped>
div#top {
  margin: 0 0 30px;
}
h3 {
  margin-top: 0;
}
</style>
