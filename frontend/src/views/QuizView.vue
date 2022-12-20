<script setup lang="ts">
import { useRoute } from "vue-router";
import { onMounted, ref } from "vue";
import router from "@/router";

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
var nameValue = "";

onMounted(() => {
  fetch(`http://localhost:8080/quiz/${id}`)
    .then((d) => {
      if (d.ok) return d.json();
      quizFound.value = false;
    })
    .then((json) => (data.value = json));
});

const submit = () => {
  localStorage.setItem("username", nameValue.substring(0, 63));
  router.push(`/quiz/${id}/play`);
};
</script>

<template>
  <main v-if="quizFound">
    <h1>{{ data?.name }}</h1>
    <p>
      by {{ data?.createdBy }} -
      {{ new Date(data?.createdOn! * 1000).toLocaleDateString("de-CH") }}
    </p>

    <form class="actions" @submit.prevent="submit">
      <input
        type="text"
        placeholder="Enter your Name"
        maxlength="64"
        v-model.trim="nameValue"
      />
      <button type="submit">Start Quiz</button>
    </form>
  </main>
  <main v-else>
    <h1>This quiz was not found.</h1>
  </main>
</template>

<style scoped>
main {
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
}

main h1 {
  margin: 0;
}

main form.actions {
  display: flex;
  justify-content: center;
  align-items: center;
  gap: 10px;
  margin-top: 100px;
}

main form.actions input {
  border: solid black 3px;
  border-radius: 0.5em;
  height: 40px;
  padding: 10px;
}

main form.actions button {
  height: 40px;
  background-color: black;
  color: white;
  border: none;
  border-radius: 0.5em;
  cursor: pointer;
  padding: 5px 10px;
  border: solid black 3px;
  font-weight: bold;
}
</style>
