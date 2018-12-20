function getLongestOutage( events ){
  var stk = [];
  events.sort(compare);
  events.forEach( function(event){
    if( stk.length == 0 || event.s > stk[stk.length - 1].e ){
      stk.push(event);
    }
    if( event.e > stk[stk.length - 1].e ){
      stk[stk.length - 1].e = event.e;
    }
  })
  stk.sort(compareLengths);
  console.log(stk[0]);
}

function compareLengths(a, b){
  if( a.e - a.s < b.e - b.s ){
    return 1;
  }
  if( a.e - a.s > b.e - b.s ){
    return -1;
  }
  return 0;
}

function compare(a, b){
  if( a.s < b.s ){
    return -1;
  }
  if( a.s > b.s ){
    return 1;
  }
  return 0;
}

var events = [ {s:5, e:7}, {s:9, e:12}, {s:15, e:20}, {s:1, e:2}, {s:17, e:23}, {s:3, e:6}, {s:4, e:5} ];
getLongestOutage( events );
