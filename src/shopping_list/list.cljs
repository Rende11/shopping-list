(ns shopping-list.list
  (:require [clojure.string :as str]))

(def goods
  {:id-1 {:desc "t-shirt"
          :price 30}
   :id-2 {:desc "bandana"
          :price 15}
   :id-3 {:desc "shades"
          :price 8}
   :id-4 {:desc "trousers"
          :price 11.5}
   :id-5 {:desc "coat"
          :price 39}
   :id-6 {:desc "hat"
          :price 42}
   :id-7 {:desc "undercoat"
          :price 79}
   :id-8 {:desc "reading glasses"
          :price 23.5}})

(defn view []
  [:div.check-list
   [:div.check-list-items
    (for [[id {:keys [desc price]}] goods]
      [:div.check-list-item {:key id}
       [:input {:type "checkbox" :id id}]
       [:label {:for id} (str (str/capitalize desc) " " price "$")]])]])
