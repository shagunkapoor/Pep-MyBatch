# Problem:
# Input: [[1,2,3], [20], [2,4,8], [1,1], [15], [11,2,4], [40], [1,2], [1,3,2], [48]]
# The array represents a book. Each element of the array is a chapter. Each number of the element represents a section of the chapter.
# The value of the number represents the number of questions in that section.
#
# You need to regroup the chapters in the book to minimize the number of overall chapters keeping the following 2 constraints in mind:
# 1. A given chapter cannot be broken down into smaller chapters
# 2. The total number of questions in a new chapter should not be more than 30
#
# Expected output:
# [[1,2,3,20,1,1], [2,4,8,15], [11,2,4,1,2,1,3,2], [40], [48]]
# Alternate output:
# [[48], [40], [20, 1, 2, 3, 1, 2], [15, 2, 4, 8], [11, 2, 4, 1, 3, 2, 1, 1]]

import heapq

def min_number_of_groups(sections, max_sum=30):

    if not sections:
        return []

    # Calculate the sum of questions for each section
    section_sums = [sum(section) for section in sections]

    section_with_sums = sorted(zip(section_sums, sections), reverse=True, key=lambda x: x[0])

    heap = []

    for section_sum, section in section_with_sums:
        # If no group can accommodate this section, create a new group
        if not heap or heap[0][0] + section_sum > max_sum:
            heapq.heappush(heap, (section_sum, [section]))
        else:
            # Pop the group with the smallest sum and add the current section to it
            min_sum, min_group = heapq.heappop(heap)
            min_group.append(section)
            heapq.heappush(heap, (min_sum + section_sum, min_group))

    return [group for _, group in heap]

# Input list of sections
sections = [[1, 2, 3], [20], [2, 4, 8], [1, 1], [15], [11, 2, 4], [40], [1, 2], [1, 3, 2], [48]]

# Get the minimum number of groups formed
output = min_number_of_groups(sections)

# Output the result
print(output)



==========================

import heapq

def min_number_of_groups(sections, max_sum=50):
    if not sections:
        return []

    # Calculate the sum of questions for each section
    section_sums = [sum(section) for section in sections]

    section_with_sums = sorted(zip(section_sums, sections), reverse=True, key=lambda x: x[0])

    heap = []

    for section_sum, section in section_with_sums:
        # If no group can accommodate this section, create a new group
        if not heap or heap[0][0] + section_sum > max_sum:
            heapq.heappush(heap, (section_sum, [section]))
        else:
            # Pop the group with the smallest sum and add the current section to it
            min_sum, min_group = heapq.heappop(heap)
            min_group.append(section)
            heapq.heappush(heap, (min_sum + section_sum, min_group))

    # Format the output as tuples
    result = [tuple(sum(group, [])) for _, group in heap]
    return result

# Input list of sections
sections = [[40], [4], [42], [8], [43], [4], [3], [19], [30], [6]]

# Get the minimum number of groups formed
output = min_number_of_groups(sections)

# Output the result
print(output)