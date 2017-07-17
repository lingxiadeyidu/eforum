package org.eforum.service.impl;

import java.util.List;

import org.eforum.entity.Article;
import org.eforum.entity.Reply;
import org.eforum.exception.ServiceException;
import org.eforum.service.ArticleService;
import org.eforum.service.ReplyService;
import org.eforum.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyServiceImpl extends BaseServiceImpl implements ReplyService {
	@Autowired
	private ArticleService articleService;

	@Override
	public void commitReply(Long articleId, String replyContent) {
		if (null == articleId) {
			throw new ServiceException("所属帖子ID不能为空!");
		}
		if (StringUtils.isNullOrEmpty(replyContent) || "<p><br></p>".equals(replyContent)) {
			throw new ServiceException("回复内容不能为空！");
		}
		Article article = articleService.findArticleById(articleId);
		if (null == article) {
			throw new ServiceException("未找到ID为【" + articleId + "】的帖子!");
		}
		Reply reply = new Reply();
		reply.setContent(replyContent);
		reply.setArticle(article);
		dao.save(reply);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Reply> getReplyByArticleId(Long articleId) {
		if (null == articleId) {
			throw new ServiceException("帖子ID不能为空！");
		}
		String hql = "FROM Reply reply WHERE reply.article.id = :id ORDER BY reply.createTime DESC";
		List<Reply> replys = (List<Reply>) dao.findByHql(hql, "id", articleId);
		return replys;
	}

	@Override
	public Long getReplyCountByArticleId(Long articleId) {
		String hql = "SELECT COUNT(*) FROM Reply reply WHERE reply.article.id = :id";
		Long replyCount = (Long) dao.findUniqueByHql(hql, "id", articleId);
		return replyCount;
	}
}
