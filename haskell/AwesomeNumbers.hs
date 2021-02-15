module Awesome.Numbers where

import Data.List

data Answer = No | Almost | Yes deriving (Show, Read, Eq, Ord)

zerosToEnd :: String -> String
zerosToEnd s = (dropWhile ( == '0') s) ++ (takeWhile ( == '0') s)

isSeqDecrementing :: String -> Bool
isSeqDecrementing s = s == (zerosToEnd . reverse . sort) s 

isSeqIncrementing :: String -> Bool
isSeqIncrementing s = s == (zerosToEnd . sort) s

isInteresting :: Integer -> [Integer] -> Answer
isInteresting x xs
 | yesCase x xs = Yes
 | almostCase x xs = Almost
 | otherwise = No
  where
    isPalindromic s = s == reverse s
    zeroFollowed s = head s /= '0' && all ( == '0') (tail s)
    twoMiles x = [x - 2, x - 1 , x + 1, x + 2]
    strX = show x
    nonEmpty ls = length ls /= 0
    yesCase n ns = let nStr = show n in  (n `elem` ns) ||  ((length nStr >= 3) && (isPalindromic nStr || zeroFollowed nStr || isSeqDecrementing nStr || isSeqIncrementing nStr))
    almostCase n ns = any (\num -> yesCase num ns) (twoMiles n)
    