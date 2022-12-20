<script setup lang="ts">
import { useRouter, useRoute } from "vue-router";

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

const router = useRouter();
const route = useRoute();
const id = route.params.id;

if (localStorage.getItem("username") === null) router.push(`/quiz/${id}`);
if (localStorage.getItem("startedOn") === null) router.push(`/quiz/${id}`);
if (localStorage.getItem("endedOn") === null) router.push(`/quiz/${id}`);
if (localStorage.getItem("currentQuestion") === null)
  router.push(`/quiz/${id}`);

const username = localStorage.getItem("username");
const progress = parseInt(localStorage.getItem("currentQuestion")!);
const startedOn = parseInt(localStorage.getItem("startedOn")!);
const endedOn = parseInt(localStorage.getItem("endedOn")!);
const gameDuration = (endedOn - startedOn) / 1000;

const gameData = {
  quizId: id,
  username,
  startedOn,
  endedOn,
  progress,
};

fetch("http://localhost:8080/games", {
  method: "POST",
  body: JSON.stringify(gameData),
}).then((d) => {
  if (d.ok) localStorage.clear();
});
</script>

<template>
  <main>
    <h3>Herzlichen Glückwunsch {{ username }}! Du hast</h3>
    <h1>{{ currencySymbol }} {{ values[15 - progress] }}</h1>
    <h3>gewonnen!</h3>
    <h2>Dauer: {{ gameDuration }}s</h2>
    <p>Dein Spiel wurde erfasst.</p>
    <a :href="'/quiz/' + id">&lt; Quiz Übersicht</a>
  </main>
</template>

<style scoped>
main {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  height: 100vh;
}

main h1 {
  margin: 0;
}
main h3 {
  margin: 0;
}

a {
  text-decoration: none;
  color: #e37d1c;
  background-color: #010a34;
  padding: 10px 30px;
  border-radius: 0.5em;
}
</style>
