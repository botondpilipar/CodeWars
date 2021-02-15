module Codewars.Kata.PrFactors where

-- Example: n = 86240 should return "(2**5)(5)(7**2)(11)"
import Data.Map
import Data.Maybe
import Data.List

primes :: [Integer] -> [Integer]
primes ls = head ls : primes (Prelude.filter (\x -> (x `mod` head ls) /= 0) (tail ls))

primeOccurrences :: Integer -> [Integer]
primeOccurrences 1 = []
primeOccurrences n = divisor : primeOccurrences (n `div` divisor)
    where divisor = head (dropWhile (\x -> n `mod` x /= 0) (primes [2..]))

doToPrimeFactor :: [Integer] -> Map Integer Integer -> Map Integer Integer
doToPrimeFactor [] countMap = countMap
doToPrimeFactor numList countMap = do {
    let key = head numList in
    let changed = if member key countMap then (adjust (+ 1) key countMap)
                    else (Data.Map.insert key 1 countMap) in
    doToPrimeFactor (tail numList) changed
}

toPrimeFactor :: [Integer] -> Map Integer Integer
toPrimeFactor nums = doToPrimeFactor nums empty

prime_factors :: Integer -> String  
prime_factors n = concat $ Prelude.map (\k -> toPrimeStrSegment k (fromJust $ Data.Map.lookup k factored)) primeKeys
    where factored = toPrimeFactor $ primeOccurrences n
          primeKeys = keys factored
          toPrimeStrSegment prime exp = 
              if exp == 1 then "(" ++ show prime ++ ")"
              else "(" ++ show prime ++ "**" ++ show exp ++ ")"