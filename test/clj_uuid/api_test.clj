(ns clj-uuid.api-test
  (:require [clojure.test :refer :all]
            [clj-uuid :refer :all]))

(comment
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Protocol Tests
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; v0 uuid protocol test
(let [tmpid +null+]
  (= (get-word-high tmpid)       0)
  (= (get-word-low tmpid)        0)
  (= (null? tmpid)           true)
  (= (to-octet-vector tmpid) [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0])
  (= (hash-code tmpid)       0)
  (= (get-version tmpid)         0)
  (= (to-string tmpid)       "00000000-0000-0000-0000-000000000000")
  (= (to-hex-string tmpid)   "00000000000000000000000000000000")   
  (= (to-urn-string tmpid)   "urn:uuid:00000000-0000-0000-0000-000000000000")
  (= (get-time-low tmpid)       [0 0 0 0])
  (= (get-time-mid tmpid)       [0 0])
  (= (get-time-high tmpid)      [0 0])
  (= (get-clk-low tmpid)        [0])
  (= (get-clk-high tmpid)       [0])
  (= (get-node-id tmpid)           [0 0 0 0 0 0])
  (= (get-timestamp tmpid)      nil)
  )

;; v1 uuid protocol test
(let [tmpid +namespace-x500+]
  (= (get-word-high tmpid)       7757371281853190609)
  (= (get-word-low tmpid)        -9172705715073830712)
  (= (null? tmpid)           false)
  (= (to-octet-vector tmpid) [107 167 184 20 157 173 17 209 128 180 0 192 79 212 48 200])
  (= (hash-code tmpid)       963287501)
  (= (get-version tmpid)         1)
  (= (to-string tmpid)       "6ba7b814-9dad-11d1-80b4-00c04fd430c8")
  (= (to-hex-string tmpid)   "6BA7B8149DAD11D180B400C04FD430C8")
  (= (to-urn-string tmpid)   "urn:uuid:6ba7b814-9dad-11d1-80b4-00c04fd430c8")
  (= (get-time-low tmpid)       [107 167 184 20])
  (= (get-time-mid tmpid)       [157 173])
  (= (get-time-high tmpid)      [17 209])
  (= (get-clk-low tmpid)        [128])
  (= (get-clk-high tmpid)       [180])
  (= (get-node-id tmpid)           [0 192 79 212 48 200])
  (= (get-timestamp tmpid)      131059232331511828)
  )


;; v3 uuid protocol test
(let [tmpid (UUID/fromString "d9c53a66-fde2-3d04-b5ad-dce3848df07e")]
  (= (get-word-high tmpid)       -2754731383046652668)
  (= (get-word-low tmpid)        -5355381512134070146)
  (= (null? tmpid)           false)
  (= (to-octet-vector tmpid) [217 197 58 102 253 226 61 4 181 173 220 227 132 141 240 126])
  (= (hash-code tmpid)       963287501)      
  (= (get-version tmpid)         3)
  (= (to-string tmpid)       "d9c53a66-fde2-3d04-b5ad-dce3848df07e")
  (= (to-hex-string tmpid)   "D9C53A66FDE23D04B5ADDCE3848DF07E")
  (= (to-urn-string tmpid)   "urn:uuid:d9c53a66-fde2-3d04-b5ad-dce3848df07e")
  (= (get-time-low tmpid)        [217 197 58 102])
  (= (get-time-mid tmpid)        [253 226])
  (= (get-time-high tmpid)       [61 4])
  (= (get-clk-low tmpid)         [181])
  (= (get-clk-high tmpid)        [173])
  (= (get-node-id tmpid)            [220 227 132 141 240 126])
  (= (get-timestamp tmpid)       nil)
  )

;; v4 uuid protocol test
(let [tmpid (UUID/fromString "3eb1e29a-4747-4a7d-8e40-94e245f57dc0")]
  (= (get-word-high tmpid)       4517641053478013565)
  (= (get-word-low tmpid)        -8196387622257066560)
  (= (null? tmpid)           false)
  (= (to-octet-vector tmpid) [62 177 226 154 71 71 74 125 142 64 148 226 69 245 125 192])
  (= (hash-code tmpid)       -1304215099)
  (= (get-version tmpid)         4)
  (= (to-string tmpid)       "3eb1e29a-4747-4a7d-8e40-94e245f57dc0")
  (= (to-hex-string tmpid)   "3EB1E29A47474A7D8E4094E245F57DC0"   )
  (= (to-urn-string tmpid)   "urn:uuid:3eb1e29a-4747-4a7d-8e40-94e245f57dc0")
  (= (get-time-low tmpid)        [62 177 226 154])
  (= (get-time-mid tmpid)        [71 71])
  (= (get-time-high tmpid)       [74 125])
  (= (get-clk-low tmpid)         [142])
  (= (get-clk-high tmpid)        [64])
  (= (get-node-id tmpid)         [148 226 69 245 125 192])
  (= (get-timestamp tmpid)       nil)
  )  

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Predicate Tests
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(uuid-string?       (to-string       (make-v4-uuid)))
(uuid-hex-string?   (to-hex-string   (make-v4-uuid)))
(uuid-urn-string?   (to-urn-string   (make-v4-uuid)))
(uuid-octet-vector? (to-octet-vector (make-v4-uuid)))


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; V0 Tests
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; V4 Tests
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; (get-timestamp (make-v4-uuid))


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; V1 Tests
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; (number? (get-timestamp (make-v1-uuid)))
;; (= (get-version   (make-v1-uuid)) 1)
;; (= (get-node-id   (make-v1-uuid)) (make-node-id))


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; V3/V5 Tests
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;


(format-digested-uuid 3 (to-octet-vector +null+))
"00000000-0000-3000-0000-000000000000"
(format-digested-uuid 3 (svec (range 0 16)))
"00010203-0405-3607-0809-0A0B0C0D0E0F"
(format-digested-uuid 5 (to-octet-vector +null+))
"00000000-0000-5000-0000-000000000000"
(format-digested-uuid 5 (svec (range 0 16)))
"00010203-0405-5607-0809-0A0B0C0D0E0F"

(= 3 (get-version (make-v3-uuid +null+ "test")))
(= 5 (get-version (make-v5-uuid +null+ "test")))

(uuid= (make-v3-uuid +null+ "test") #uuid"052c0ae9-722c-39ec-0743-9dd29c94efe4")
(uuid= (make-v5-uuid +null+ "test") #uuid"c7913647-8df1-5968-984a-4c33308a8f9b")  


)
