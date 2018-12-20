var dailyTemps = function( temps ){
  var result = [];
  var stack = [];
  for( var i = temps.length - 1; i >= 0; i-- ){
    while( stack.length > 0 && temps[i] >= temps[stack[stack.length - 1]]){
      stack.pop();
    }
    result[i] = stack.length == 0 ? 0 : stack[stack.length - 1] - i;
    stack.push(i);
  }
  console.log(result);
}

dailyTemps([1, 2, 3, 4, 5])
dailyTemps([5, 4, 3, 2, 1])
dailyTemps([1, 1, 1, 1, 1])
dailyTemps([5, 4, 3, 2, 1, 1, 2, 3, 4, 5])
dailyTemps([1, 2, 3, 4, 5, 5, 4, 3, 2, 1])
