(ns shopping-list.app
  (:require [reagent.dom :as rdom]))

(defn app
  []
  [:div "Hello from app"])

(defn ^:dev/after-load render []
  (rdom/render [app] (.getElementById js/document "app")))

(defn ^:export main
  []
  (render))
