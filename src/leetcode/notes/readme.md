# Notes

## Initialize an ArrayList with List.of()

List<Character> open = new ArrayList<>(List.of('(','{','['));

List<Character> close = new ArrayList<>(List.of(')','}',']'));

## PriorityQueue sort example
// init heap 'the smallest element first'
PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2)->n1-n2);