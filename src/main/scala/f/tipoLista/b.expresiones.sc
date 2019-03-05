List(1+1, 2+2, 3+3)
List((1>2, 2>3), (3>4, 4>5))
List(List(1, 2, 3), Nil, List(666))

List(1,2)==List(1,2)
List(List())!=List()
if (4>2) List(3*2,2+3) else List()

List(3,5,6).head
List(3,5,6).tail
List(3).head
List(5).tail
//List().head
//List().tail

1::Nil
1::List()
1::2::List()
1::2::3::4::List()


List(List(1,2),Nil,List(3))

(1::2::Nil)::Nil::(3::Nil)::Nil



List(1)::Nil::Nil

List(1,2)::List(3,4)

