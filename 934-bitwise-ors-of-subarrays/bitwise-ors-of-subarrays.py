from typing import List

class Solution:
    def subarrayBitwiseORs(self, arr: List[int]) -> int:
        result = set()
        current = set()

        for num in arr:
            # Compute all ORs for subarrays ending with this element
            current = {num | x for x in current} | {num}
            result |= current  # Union with all previously found ORs

        return len(result)
