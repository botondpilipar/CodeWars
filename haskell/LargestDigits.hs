module LargestDigits where

import Text.Read

fiveSeq :: String -> [String]
fiveSeq (a:b:c:d:e:[]) = [[a,b,c,d,e]]
fiveSeq ls@(a:b:c:d:e:xs) = [[a,b,c,d,e]] ++ fiveSeq (drop 1 ls)
fiveSeq x = [[]]

readToInt :: String -> Int
readToInt x = read x :: Int

digit5 :: String -> Int
digit5 = maximum . map readToInt . fiveSeq
