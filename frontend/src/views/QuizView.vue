<script setup lang="ts">
import { useRoute } from "vue-router";
import { onMounted, ref } from "vue";

interface Quiz {
  id: string;
  name: string;
  createdBy: string;
  createdOn: number;
  tags: string[];
}

const route = useRoute();
const id = route.params.id;
var data = ref<null | Quiz>();
const quizFound = ref(true);

onMounted(() => {
  fetch(`http://localhost:8080/quiz/${id}`)
    .then((d) => {
      if (d.ok) return d.json();
      quizFound.value = false;
    })
    .then((json) => (data.value = json));
});
</script>

<template>
  <div v-if="quizFound">
    <h1>{{ data?.name }}</h1>
    <p>by {{ data?.createdBy }}</p>
    <p>{{ new Date(data?.createdOn! * 1000).toLocaleDateString("de-CH") }}</p>

    <input type="text" placeholder="Enter your Name" />
    <button type="submit">Start Quiz</button>
  </div>
  <div v-else>
    <h1>This quiz was not found.</h1>
  </div>
</template>

<style scoped></style>
