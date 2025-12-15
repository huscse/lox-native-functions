globals.define("newNative", new LoxCallable() {
    @Override
    public int arity() {
        return 0; // no arguments here
    }

    @Override
    public Object call(Interpreter Interpreter, List<Object> arguments) {
        return "new native function";
    }

    @Override
    public String toString() {
        return "native fn>";
    }

});



globals.define("Triples", new LoxCallable () {
    @Override
    public int arity() {
        return 1;
    }

    @Override
    public Object call(Interpreter interpreter, List<Object> arguments) {
        double n = (double) arguments.get(0);
        return 3 * n;
    }

    @Override
    public String toString() {
        return "<native fn>";
    }

});



globals.define("max2", new LoxCallable() {
    @Override
    public int arity() {
        return 2;
    }

    @Override
    public Object call(Interpreter interpreter, List<Object> arguments) {
        double n = (double) arguments.get(0);
        double m = (double) arguments.get(1);
        return (a > b) ? a : b;
    }

    @Override
    public String toString() {
        return "<native fn";
    }
});


globals.define("native", new LoxCallable() {
    @Override
    public int arity() {
        return 0;
    }

    @Override
    public Object call(Interpreter interpreter, List<Object> arguments) {
        return "Hello Lox";
    }

    @Override
    public String toString() {
        return "<native fn>";
    }

});



globals.define("addOne", new LoxCallable() {
    @Override
    public int arity() {
        return 1;
    }

    @Override
    public Object call(Interpreter interpreter, List<Object> arguments) {
        double n = (double) arguments.get(0);
        return 1 + n;
    }

    @Override
    public String toString() {
        return "<native fn>";
    }
});



// Visit while and if
// Visit If
public Object visitIfStmt(Stmt.If stmt) {
    if (isTruthy(evaluate(stmt.condition))) {
        execute(stmt.thenBranch);
    } else if (stmt.elseBranch != null) {
        execute(stmt.elseBranch);
    }
    return null;
}

// Visit while
public Object visitWhileStmt(Stmt.While stmt) {
    while (isTruthy(evaluate(stmt.condition))) {
        execute(stmt.body);
    } 
    return null;
}


// // String matching algorithm (naive) -> O(n * m)
// for i in 0..(n - m): // n = len(Text), m = len(Pattern)
//     match = true
//     for j in 0..(m - 1):
//         if T[i + j] != P[j]: // if the char in Text at i != to char in Pattern at j (same pos)
//             match = false
//             break

//     if match:
//         return "Match found at: ", i


// QUICKSORT(A, low, high):
// if low < high:
//     p = PARTITION(A, low, high)
//     QUICKSORT(A, low, p - 1)
//     QUICKSORT(A, p + 1, high)

// PARTITION(A, low, high):
//     pivot = A[high]
//     i = low - 1

//     for j = low to high - 1:
//         if A[j] <= pivot:
//             i = i + 1
//             SWAP A[i] with A[j]

//     SWAP A[i + 1] with A[high]
//     return i + 1



// // Modified PARTITION algo for special input case -> when all elements in array are equal:
// PARTITION(A, low, high)
// pivot = A[high]

// allEqual = true
// for c = low to high:
//     if A[c] != pivot:
//         allEqual = false
//         break

// if allEqual:
//     return floor(low + high) // 2

// i = low - 1
// for j = low to high - 1:
//     if A[j] <= pivot:
//         i = i+ 1
//         SWAQ A[i] with A[j]

// SWAP A[i + 1] with A[high]
// return i + 1


// QUICKSORT-RANDOM(A, low, high):
//     if low < high:
//         p = RANDOM-PARTITION(A, low, high)
//         QUICKSORT-RANDOM(A, low, p - 1)
//         QUICKSORT-RANDOM(A, p + 1, high)

// RANDOM-PARTITION(A, low, high):
//     pivot = RANDOM(low, high)
//     i = low - 1

//     for j = low to high - 1:
//         if A[j] <= pivot:
//             i = i + 1
//             SWAP A[i] with A[j]

//     SWAP A[i + 1] with A[high]
//     return i + 1

// Binary search trees

// // tree traversals

// In-order Traversal -> left -> node -> right

// In-Order(x):
//     if x != NIL:
//         In-Order(x.left)
//         print x.key
//         In-Order(x.right)

// // Pre-order(x):
//     if x != NIL:
//         print x.key
//         Pre-order(x.left)
//         Pre-order(x.right)
    
// // Post-order(x):
//     if x.key != NIL:
//         Post-order(x.left)
//         Post-order(x.right)
//         Post-order x.key


// // BST - Search O(h):

// BST-search(x, k):   x -> curr node, k -> what we're looking for
//     if x == NIL or k = x.key:
//         return x

//     if k < x.key:
//         return BST-search(x.left, k)
    
//     else:
//         return BST-search(x.right, k)


// // BST-Successor - O(h)
// Binary-successor(x):
//     if x.right != NIL:
//         return Tree-Minimum(x.right)

//     y = x.p
//     while y != NIL and x = y.right:
//         x = y
//         y = y.p 

//     return y

// Tree-Minimun(x):
//     if x.left == NIL:
//         return x
    
//     else:
//         return Tree-Minimum(x.left)


// // BST - Predecessor

// BST-Predecessor(x):
//     if x.left != NIL:
//         return Tree-Maximum(x.left)

//     y = x.p 
//     while y != NIL and x = y.left:
//         x = y
//         y = y.p 
    
//     return y

// Tree-Maximum(x):
//     if x.right == NIL:
//         return x

//     else:
//         return Tree-Maximum(x.right)




// // BST-insert - O(h)  -> insert a new node in a bst without breaking bst rule

// BST-insert(T, z):  // T -> the tree, z -> the new node we want to insert
//     x = T.root    // current node
//     y = NIL      // parent of the new node, we keep track

//     while x != NIL: // while current node exists
//         y = x      // y -> parent of curr node

//         if z.key < x.key:  // if value of new node < curr node
//             x = x.left    // go left
        
//         else:
//             x = x.right  // go right

//     z.p = y  // parent of new node => y
//     if y == NIL:  // if tree does not exist
//         T.root = z  // set z to be root of tree
    
//     else if z.key < y.key:  // if new node's < parent node
//         y.left = z         // new node (z) would be left child.
    
//     else:
//         y.right = z      // new node (z) would be right child.
