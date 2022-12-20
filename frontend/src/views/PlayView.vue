<script setup lang="ts">
import { onMounted, ref } from "vue";
import { useRouter, useRoute } from "vue-router";

interface Question {
  id: string;
  question: string;
  answer1: string;
  answer2: string;
  answer3: string;
  answer4: string;
}

const router = useRouter();
const route = useRoute();
const id = route.params.id;
const questionData = ref<null | Question>();
const currentQuestion = ref(1);
const dataLoaded = ref(false);
const somethingWentWrong = ref(false);

if (localStorage.getItem("username") === null) router.push(`/quiz/${id}`);

onMounted(() => fetchQuestion());

const fetchQuestion = () => {
  dataLoaded.value = false;
  fetch(`http://localhost:8080/quiz/${id}/question/${currentQuestion.value}`)
    .then((d) => {
      if (d.ok) return d.json();
      somethingWentWrong.value = true;
    })
    .then((json) => {
      questionData.value = json;
      dataLoaded.value = true;
    });
};
</script>

<template>
  <div v-if="dataLoaded">
    <h1>{{ questionData?.question }}</h1>
    <ul>
      <li>{{ questionData?.answer1 }}</li>
      <li>{{ questionData?.answer2 }}</li>
      <li>{{ questionData?.answer3 }}</li>
      <li>{{ questionData?.answer4 }}</li>
    </ul>
  </div>
  <div v-else-if="somethingWentWrong">
    <h1>Something went wrong while loading.</h1>
  </div>
  <div v-else>
    <h1>Loading...</h1>
  </div>
</template>
