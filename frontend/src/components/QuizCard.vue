<script setup lang="ts">
const props = defineProps(["data"]);
const data = props.data;
</script>

<template>
  <a :href="'quiz/' + data.id">
    <div class="card">
      <h3>
        {{ data.name
        }}<span>{{
          new Date(data.createdOn * 1000).toLocaleDateString("de-CH")
        }}</span>
      </h3>
      <p>by {{ data.createdBy }}</p>
      <div class="tags">
        <span v-for="tag in data.tags" :key="tag">#{{ tag }}</span>
      </div>
    </div>
  </a>
</template>

<style scoped>
a {
  text-decoration: none;
}

.card {
  background-color: white;
  color: black;
  border: black solid 3px;
  border-radius: 0.5em;
  padding: 20px 50px;
  width: 600px;
}

h3 {
  margin: 0;
  text-overflow: ellipsis;
  overflow: hidden;
  white-space: nowrap;
}

h3 span {
  font-size: 0.7rem;
  font-weight: 100;
  margin-left: 10px;
}

p {
  margin: 0;
}

div.tags span {
  margin-right: 5px;
  color: #2f66e9;
}
</style>
