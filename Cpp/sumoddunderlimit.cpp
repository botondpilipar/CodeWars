#include "sumoddunderlimit.h"
#include <ranges>
#include <numeric>
#include <iostream>
#include <functional>


SumOddUnderLimit::SumOddUnderLimit()
{

}

int SumOddUnderLimit::sumOddUnderLimit(int limit)
{
    auto odd = [](auto i) { return i % 3 == 0;};
    int sum = 0;

    for (int i : std::views::iota(1, limit) | std::views::filter(odd)) {
        sum += i;
    }
    return sum;
}
