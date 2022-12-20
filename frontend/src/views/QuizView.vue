<script setup lang="ts">
import { useRoute } from "vue-router";
import { onMounted, ref } from "vue";
import router from "@/router";

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

interface Quiz {
  id: string;
  name: string;
  createdBy: string;
  createdOn: number;
  tags: string[];
}

interface LeaderboardScore {
  username: string;
  quizId: string;
  progress: number;
  startedOn: number;
  endedOn: number;
}

const route = useRoute();
const id = route.params.id;
var data = ref<null | Quiz>();
var leaderBoard = ref<null | LeaderboardScore[]>();
const quizFound = ref(true);
var nameValue = "";

onMounted(() => {
  fetch(`http://localhost:8080/quiz/${id}`)
    .then((d) => {
      if (d.ok) return d.json();
      quizFound.value = false;
    })
    .then((json) => (data.value = json));

  fetch(`http://localhost:8080/games/${id}`)
    .then((d) => {
      if (d.ok) return d.json();
    })
    .then((json) => (leaderBoard.value = json));
});

const submit = () => {
  localStorage.setItem("username", nameValue.substring(0, 63));
  router.push(`/quiz/${id}/play`);
};
</script>

<template>
  <main v-if="quizFound">
    <a href="/">Zurück</a>
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
    <table class="leaderboard" v-if="leaderBoard">
      <tr>
        <th>#</th>
        <th>Username</th>
        <th>Winnings</th>
        <th>Time</th>
        <th>Date</th>
      </tr>
      <tr v-for="(score, index) in leaderBoard">
        <td>{{ index + 1 }}</td>
        <td>{{ score.username }}</td>
        <td>{{ currencySymbol }} {{ values[15 - score.progress] }}</td>
        <td>{{ (score.endedOn - score.startedOn) / 1000 }}s</td>
        <td>{{ new Date(score.endedOn).toLocaleString("de-CH") }}</td>
      </tr>
    </table>
    <p v-else>Leaderboard is loading...</p>
  </main>
  <main v-else>
    <a href="/">&lt; Home</a>
    <h1>This quiz was not found.</h1>
  </main>
</template>

<style scoped>
a {
  text-decoration: none;
  color: #e37d1c;
  background-color: #010a34;
  padding: 10px 30px;
  border-radius: 0.5em;
  margin-bottom: 15px;
}

main {
  padding-top: 150px;
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

table {
  margin-top: 30px;
}

td,
th {
  padding: 0 10px;
}
table tr th {
  text-align: left;
}
</style>
