# HandleImage
这里主要是代码部分,我会稍微讲解下用到的方法,另外会配上几张图片,具体的内容可以看我的[CSDN博客](http://blog.csdn.net/jackiesun1992/article/details/52254770)<br>
重点是要说一下ColorMatrix这个类,看名字就可以知道是颜色矩阵,可以修改矩阵的值来改变图片.<br>
<img src="https://github.com/JackieSCN/HandleImage/raw/master/Logo/gongshi.png"
 width="400" height="200"/><br>
上述公式就是经过计算得到新的矩阵值.<br>

接下来看点范例的效果图:<br>
<img src="https://github.com/JackieSCN/HandleImage/raw/master/Logo/argb_view.png" width="400" height="400"/><br>
这个rgba修改的页面<br>
<img src="https://github.com/JackieSCN/HandleImage/raw/master/Logo/matrix_origin.png" width="300" height="300"/>
<img src="https://github.com/JackieSCN/HandleImage/raw/master/Logo/matrix_old.png" width="300" height="300"/><br>
上述图片是利用矩阵值修改前后的对比图<br>
<img src="https://github.com/JackieSCN/HandleImage/raw/master/Logo/pixel_view.png" width="400" height="400"/><br>
这个是修改像素点之后产生的不同效果,怀旧,底片,浮雕效果<br>
