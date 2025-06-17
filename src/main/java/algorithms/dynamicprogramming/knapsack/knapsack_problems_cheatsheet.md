# Knapsack-Type Problems Cheat Sheet

| Problem                          | Knapsack Type               | Notes                                                                 |
|----------------------------------|-----------------------------|-----------------------------------------------------------------------|
| 0/1 Knapsack                     | Classic                     | Maximize value with weight ≤ W; each item picked at most once (0 or 1). |
| Unbounded Knapsack              | Classic, reuse allowed      | Maximize value with weight ≤ W; each item can be picked unlimited times. |
| Fractional Knapsack             | Greedy (not DP)             | Maximize value by taking fractions of items; sort by value/weight ratio. |
| Subset Sum                      | 0/1 Knapsack variant        | Check if a subset sums to target W (value = weight, boolean output).  |
| Partition Equal Subset Sum     | Subset Sum variant          | Check if array can be split into two subsets with equal sum (sum/2). |
| Count Subsets with Sum         | Counting variant            | Count number of subsets summing to target W (combinatorial).         |
| Minimum Subset Sum Difference  | Optimization variant        | Minimize absolute difference between two subset sums.                |
| Target Sum                      | Sign assignment             | Assign + or - to numbers to reach target sum (reduces to Subset Sum). |
| Bounded Knapsack               | Limited reuse               | Each item can be picked up to c[i] times; often solved via 0/1 Knapsack. |
| Knapsack with Value Constraint | Value-based optimization    | Minimize weight for value ≥ V or maximize value for value ≤ V.       |
| Counting Ways (Unbounded)      | Unbounded counting variant  | Count ways to achieve sum W with unlimited use of items (e.g., Coin Change II). |
