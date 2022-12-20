<script setup lang="ts">
import WinningsProgress from "@/components/WinningsProgress.vue";
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
const somethingWentWrong = ref(false);
const hasAnswered = ref(0);
const hasAnsweredCorrectly = ref(false);

if (localStorage.getItem("username") === null) router.push(`/quiz/${id}`);

onMounted(() => fetchQuestion());

const fetchQuestion = () => {
  fetch(`http://localhost:8080/quiz/${id}/question/${currentQuestion.value}`)
    .then((d) => {
      if (d.ok) return d.json();
      somethingWentWrong.value = true;
    })
    .then((json) => {
      questionData.value = json;
    });
};

const click = (clickedAnswer: number) => {
  if (hasAnswered.value !== 0) return;
  hasAnswered.value = clickedAnswer;
  fetch(
    `http://localhost:8080/question/${questionData.value?.id}/check/${clickedAnswer}`
  )
    .then((d) => {
      if (d.ok) return d.json();
      somethingWentWrong.value = true;
    })
    .then((json) => {
      hasAnsweredCorrectly.value = json.answer;
    });
};
const nextQuestion = () => {
  if (!hasAnsweredCorrectly) return;
  hasAnsweredCorrectly.value = false;
  hasAnswered.value = 0;
  currentQuestion.value++;
  fetchQuestion();
};
</script>

<template>
  <main v-if="questionData?.id">
    <div class="question">
      <div class="actions">
        <button :class="hasAnsweredCorrectly ? '' : 'locked'">
          &lt; Take the money
        </button>
        <button
          :class="hasAnsweredCorrectly ? '' : 'locked'"
          @click="nextQuestion"
        >
          Continue &gt;
        </button>
        <button
          :class="!hasAnsweredCorrectly && hasAnswered !== 0 ? '' : 'locked'"
        >
          Results &gt;
        </button>
      </div>
      <h3>Question {{ currentQuestion }}</h3>
      <h1>
        <span>{{ questionData?.question }}</span>
      </h1>
      <div class="answergrid">
        <p
          @click="click(1)"
          :class="
            hasAnswered !== 0
              ? hasAnswered === 1 && hasAnsweredCorrectly
                ? 'correct'
                : hasAnswered === 1
                ? 'wrong'
                : 'a'
              : ''
          "
        >
          <span>{{ questionData?.answer1 }}</span>
        </p>
        <p
          @click="click(2)"
          :class="
            hasAnswered !== 0
              ? hasAnswered === 2 && hasAnsweredCorrectly
                ? 'correct'
                : hasAnswered === 2
                ? 'wrong'
                : 'a'
              : ''
          "
        >
          <span>{{ questionData?.answer2 }}</span>
        </p>
        <p
          @click="click(3)"
          :class="
            hasAnswered !== 0
              ? hasAnswered === 3 && hasAnsweredCorrectly
                ? 'correct'
                : hasAnswered === 3
                ? 'wrong'
                : 'a'
              : ''
          "
        >
          <span>{{ questionData?.answer3 }}</span>
        </p>
        <p
          @click="click(4)"
          :class="
            hasAnswered !== 0
              ? hasAnswered === 4 && hasAnsweredCorrectly
                ? 'correct'
                : hasAnswered === 4
                ? 'wrong'
                : 'a'
              : ''
          "
        >
          <span>{{ questionData?.answer4 }}</span>
        </p>
      </div>
    </div>
    <WinningsProgress :current="currentQuestion" />
  </main>
  <main v-else-if="somethingWentWrong">
    <h1>Something went wrong while loading.</h1>
  </main>
  <main v-else>
    <h1>Loading...</h1>
  </main>
</template>

<style scoped>
main {
  display: flex;
  justify-content: center;
  align-items: center;
  /* flex-direction: column; */
}

main .winningprogress {
  margin: 50px 0 50px 30px;
  width: 300px;
}

div.question {
  margin-top: 40px;
  width: 70%;
}

div.question div.answergrid {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-wrap: wrap;
}

div.question .correct,
div.question .correct:hover {
  background: none;
  background-color: green !important;
}
div.question .wrong,
div.question .wrong:hover {
  background: none;
  background-color: red !important;
}

div.actions button:first-child {
  margin-left: calc(5% + 15px);
}
div.actions button {
  margin: 0;
  margin-left: 10px;
  color: #e37d1c;
  border: #010a34 solid 3px;
  border-radius: 0.5em;
  font-weight: 1000;
  padding: 14px 40px;
  background-color: #010a34;
  margin-bottom: 40px;
  cursor: pointer;
}

div.actions button.locked {
  color: #010a34;
  cursor: not-allowed;
}

div.question h3 {
  margin: 0;
  margin-left: calc(5% + 15px);
  color: #010a34;
}
div.question h1 {
  margin-top: 0;
  clip-path: polygon(0 50%, 5% 100%, 95% 100%, 100% 50%, 95% 0, 5% 0);
  text-align: center;
  background-color: #010a34;
  height: 100px;
  display: flex;
  justify-content: center;
  align-items: center;
  color: #e37d1c;
}

div.question div.answergrid p {
  padding: 30px 0;
  background-color: #010a34;
  color: #e37d1c;
  height: 100%;
  --x-margin: 40px;
  width: calc(50% - 2 * var(--x-margin));
  margin: 10px var(--x-margin);
  clip-path: polygon(0 50%, 10% 100%, 90% 100%, 100% 50%, 90% 0, 10% 0);
  display: flex;
  justify-content: center;
  align-items: center;
}
div.question div.answergrid p:not(.correct):not(.wrong):not(.a):hover {
  background: radial-gradient(#f58a0a, #d5761f, #faf7b5);
  cursor: pointer;
  color: #010a34;
}
</style>
