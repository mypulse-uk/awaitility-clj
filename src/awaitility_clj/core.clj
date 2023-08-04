(ns awaitility-clj.core
  (:require
    [clojure.string :as str]
    [org.bovinegenius.exploding-fish :as ef]))

(defn absolute?
  [uri]
  (try (ef/absolute? uri)
       (catch Exception _)))

(defn ends-with?
  [^CharSequence s ^String substr]
  (try (str/ends-with? s substr)
       (catch Exception _)))

(defn path
  [uri]
  (try (ef/path uri)
       (catch Exception _)))

(defn query-map
  [uri]
  (try (ef/query-map uri)
       (catch Exception _)))

(defn params
  ([uri]
   (try (ef/params uri)
        (catch Exception _)))
  ([uri param-key]
   (try (ef/params uri param-key)
        (catch Exception _))))

(defn query
  [uri new-query]
  (try (ef/query uri new-query)
       (catch Exception _)))

(defn without-query
  [uri]
  (try (ef/query uri nil)
       (catch Exception _)))
