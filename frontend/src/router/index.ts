import { createRouter, createWebHistory } from "vue-router";
import HomeView from "../views/HomeView.vue";
import QuizView from "../views/QuizView.vue";
import PlayView from "../views/PlayView.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "home",
      component: HomeView,
    },
    {
      path: "/quiz/:id",
      name: "quiz",
      component: QuizView,
    },
    {
      path: "/quiz/:id/play",
      name: "quizPlay",
      component: PlayView,
    },
  ],
});

export default router;
