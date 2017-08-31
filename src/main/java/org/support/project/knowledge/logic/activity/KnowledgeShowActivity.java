package org.support.project.knowledge.logic.activity;

import org.support.project.common.log.Log;
import org.support.project.common.log.LogFactory;
import org.support.project.di.Container;
import org.support.project.di.DI;
import org.support.project.di.Instance;

/**
 * 
 * 種類  | 獲得のタイプ  | ポイント付与先 | ポイント    | 獲得タイプの意味
 * 2    | 21          | 参照者       | 1        | 記事を参照するアクションを行うと、参照者にポイント追加（一つの記事に付き1回のみ）
 * 2    | 22          | 記事登録者    | 1        | 自分が登録された記事が参照されたら、登録者にポイント追加（一つの記事に対し、参照者毎に1回のみ）
 * 2    | 23          | 記事         | 1        | 記事が参照されると、その記事のポイントが追加（一つの記事に対し、参照者毎に1回のみ）
 * 
 * @author koda
 */
@DI(instance = Instance.Prototype)
public class KnowledgeShowActivity extends AbstractAddPointForKnowledgeProcessor {
    private static final Log LOG = LogFactory.getLog(KnowledgeShowActivity.class);
    public static KnowledgeShowActivity get() {
        return Container.getComp(KnowledgeShowActivity.class);
    }
    
    @Override
    protected Activity getActivity() {
        LOG.info("Start add point process on show knowledge.");
        return Activity.KNOWLEDGE_SHOW;
    }
    @Override
    protected TypeAndPoint getTypeAndPointForActivityExecuter() {
        return new TypeAndPoint(TYPE_KNOWLEDGE_DO_SHOW, 1);
    }
    @Override
    protected TypeAndPoint getTypeAndPointForKnowledgeOwner() {
        return new TypeAndPoint(TYPE_KNOWLEDGE_SHOWN_BY_OHER, 1);
    }
    @Override
    protected TypeAndPoint getTypeAndPointForKnowledge() {
        return new TypeAndPoint(TYPE_KNOWLEDGE_SHOWN, 1);
    }

}
