(ns hello-mcp-clj.completion
  (:require
   [clojure.string :as str]
   [plumcp.core.api.capability :as cap]
   [plumcp.core.api.entity-gen :as eg]))


(def cuisines
  (->> ["Indian"
        "North Indian"
        "South Indian"
        "Indonesian"
        "Italian"
        "Japanese"
        "Mexican"
        "Thai"]
       (mapv (fn [cuisine]
               [(str/lower-case cuisine) cuisine]))))


(def cuisine-completion
  "Cuisine completion implemented using naive sequential search for demo
   and learning purpose."
  (cap/make-completions-reference-item
   (eg/make-prompt-reference "cuisine-search")
   (fn [{:keys [ref cuisine]}]
     (let [user-cuisine (str/lower-case cuisine)
           matches (->> cuisines
                        (filterv (fn [[lower-cuisine _]]
                                   (str/includes? lower-cuisine
                                                  user-cuisine)))
                        (mapv second))]
       (eg/make-complete-result matches)))))
