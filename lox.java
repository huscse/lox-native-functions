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