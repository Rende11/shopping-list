(ns shopping-list.list
  (:require [clojure.string :as str]
            [reagent.core :as r]))

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


(defn ->usd [v]
  (str v "$"))

(defn view []
  (let [state (r/atom {:goods goods
                       :total 0})]
    (fn []
      [:div.check-list
       [:div.check-list-items
        (doall
         (for [[id {:keys [desc price selected]}] (:goods @state)]
           [:div.check-list-item {:key id}
            [:input {:type "checkbox" :id id
                     :disabled (and (> (+ price (:total @state)) 100) (not selected))
                     :on-change #(swap! state (fn [g]
                                                (-> g
                                                    (update-in [:goods id :selected] not)
                                                    (update :total (if selected - +) price))))}]
            [:label {:for id} (str (str/capitalize desc) " " (->usd price))]]))]
       [:div.check-list-total
        "Total: " (->usd (:total @state))]])))
