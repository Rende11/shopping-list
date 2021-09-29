(ns shopping-list.app
  (:require [reagent.dom :as rdom]
            [shopping-list.list :as list]))

(defn app
  []
  [list/view])

(defn ^:dev/after-load render []
  (rdom/render [app] (.getElementById js/document "app")))

(defn ^:export main
  []
  (render))
