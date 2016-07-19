// JavaScript Document
	 	function openTab(t)
		{
			
			var title=$(t).text();
			var url=$(t).attr("rel");
			var icon=$(t).attr("icon");
			
			OpenTab(title,url);
		}
		
		function OpenTab(title, url)
		{
			if($("#tabs").tabs('exists', title))
			{
				//先把对应的选项卡关闭
				$("#tabs").tabs('close', title);
				//重新加载对应的选项卡
				$("#tabs").tabs('add',{
					title: title,
					content: createTabContent(url),
					closable: true
				});
//				当前选项卡选中
//				$("#tabs").tabs('select', title);
			}
			else
			{
				$("#tabs").tabs('add',{
					title: title,
					content: createTabContent(url),
					closable: true
				});
			}	
		}
		
		function createTabContent(url)
		{
			
			return '<iframe style="width:100%;height:100%;" scrolling="auto" frameborder="0" src="' + url + '"></iframe>';
		}