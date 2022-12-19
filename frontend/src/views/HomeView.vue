<script setup lang="ts">
import QuizzesSearch from "@/components/QuizzesSearch.vue";
</script>

<template>
  <main>
    <div id="welcome">
      <p>Wilkommen bei:</p>
      <h1>Wer wird Millionär</h1>
    </div>
    <QuizzesSearch />
  </main>
</template>

<style scoped>
main {
  display: flex;
  justify-content: flex-start;
  align-items: center;
  flex-direction: column;
}

#welcome {
  margin: 30px 0;
}
#welcome p {
  text-align: center;
  margin: 0;
}
#welcome h1 {
  margin: 0;
  font-family: "Anton", sans-serif;
}
</style>
