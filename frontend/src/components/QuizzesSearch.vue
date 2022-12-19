<script setup lang="ts">
import QuizCard from "./QuizCard.vue";
</script>

<template>
  <div>
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

<style></style>
