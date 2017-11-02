# https://techdevguide.withgoogle.com/paths/foundational
# Created 10.01.2017 by CB Fay
# Updated 10.18.2017 by CB Fay

# Given a string S and a set of words D, find the longest word in D that is a subsequence of S.

S = 'hearing'
D = ['a', 'bee', 'caribou', 'devastated', 'ear', 'car', 'earing', 'in', 'frantic', 'xylophone', 'hear', 'ring']
W = '' # the String that will hold the final output

max = 0 # the largest length of any subseq found in D
bRef = 0 # reference to the largest subseq in D

# sort a list based on the length of its elements
def sortlen(list):
    return sorted(list, key=len)

# compares two words to see if b is contained in a, if letters in a can be removed, but not re-ordered
def lenSubSeq(a, b):

    if(len(b) < max):
        return-2
    if(len(b) > len(a)):
        return -1

    ac = 0 # (a count) index of a
    c = 0 # (count) the length of the subseq
    for ib in range(0,len(b),1):
        for ia in range(ac,len(a),1):
            if a[ia] == b[ib]:
                c += 1
                ac += 1
                break
            ac += 1
    return c

# a simple solution...
# compare each string in D with S, and skip all strings that are smaller than the biggest element already found, or larger than S.
def solut1():
    global max
    locBRef = bRef

    for i in range(0,len(D),1):
        current = (lenSubSeq(S, D[i]))
        # print(D[i], current)
        if current > max:
            max = current
            locBRef = i

    return(D[locBRef])

# a second solution...
# sort the list by string length, and start checking the longest strings until an subseq is found
def solut2():

    locBRef = bRef
    E = sortlen(D)
    for i in range(len(E)-1,-1,-1):
        # print(E[i], (lenSubSeq(S, E[i])))
        if (lenSubSeq(S, E[i])) >= 1:
            # print('FOUND!\n')
            return(E[i])

def main():
    print(solut1())
    print(solut2())

if __name__ == "__main__":
    main()
