(ns awaitility-clj.core-test
  (:require
    [clojure.test :refer [deftest is testing]]
    [awaitility-clj.core :refer
     [absolute? path ends-with? query-map params query without-query]]))

(deftest absolute-should-not-throw
  (testing "absolute? should not throw"
    (testing "with valid data"
      (is (absolute? "https://example.com")))
    (testing "with nil"
      (is (nil? (absolute? nil))))
    (testing "with other data types"
      (is (nil? (absolute? 123)))
      (is (nil? (absolute? [])))
      (is (nil? (absolute? {}))))))

(deftest ends-with-should-not-throw
  (testing "ends-with? should not throw"
    (testing "with valid data"
      (is (ends-with? "https://example.com" "com")))
    (testing "with nil"
      (is (nil? (absolute? nil))))))

(deftest path-should-not-throw
  (testing "path should not throw"
    (testing "with valid data"
      (is (path "https://example.com/foo")))
    (testing "with nil"
      (is (nil? (path nil))))))

(deftest query-map-should-not-throw
  (testing "query-map should not throw"
    (testing "with valid data"
      (is (query-map "https://example.com"))
      (is (query-map "https://example.com?foo=bar")))
    (testing "with nil"
      (is (nil? (query-map nil))))))

(deftest params-should-not-throw
  (testing "params should not throw"
    (testing "with valid data"
      (is (params "https://example.com?foo=bar" "foo"))
      (is (params "https://example.com?foo=bar")))
    (testing "with nil"
      (is (nil? (params nil nil)))
      (is (nil? (params nil))))))

(deftest query-should-not-throw
  (testing "query should not throw"
    (testing "with valid data"
      (is (query "https://example.com" nil))
      (is (query "https://example.com?foo=bar" "?test=param")))
    (testing "with nil"
      (is (nil? (query nil nil))))))

(deftest without-query-removes-query-string
  (testing "without-query removes query string"
    (testing "with valid data"
      (is (= (without-query "https://example.com?foo=bar") "https://example.com")))
    (testing "with nil"
      (is (nil? (without-query nil))))))
