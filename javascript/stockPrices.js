var stockPrices = function( prices ){
  var result = [];
  var stack = [];

  for( var i = 0; i < prices.length; i++ ){
    while( stack.length > 0 && prices[i] >= prices[stack[stack.length - 1]]){
      stack.pop();
    }
    result[i] = stack.length == 0 ? 0 : i - stack[stack.length - 1];
    stack.push(i);
  }

  console.log(result);
}

stockPrices([1, 2, 3, 4, 5])
stockPrices([5, 4, 3, 2, 1])
stockPrices([1, 1, 1, 1, 1])
stockPrices([1, 2, 3, 4, 5, 5, 4, 3, 2, 1])
stockPrices([5, 4, 3, 2, 1, 1, 2, 3, 4, 5])
